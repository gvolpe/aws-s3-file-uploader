package aws

import awscala._, s3._
import scala.collection.JavaConverters._
import java.io.FileInputStream

object AWSFileService {

  // EU_Ireland = eu-west-1 >> http://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region
  //implicit val s3 = S3.at(Region.EU_Ireland.toAWSRegion())
  //implicit val s3 = S3(Credentials("CONSULTAR-SYSADMIN", "CONSULTAR-SYSADMIN"))

  implicit val s3 = S3()

  private val bucketName = "etermax-profile-picture"
  private val rootFolder = "playchat/"

  type Summary = com.amazonaws.services.s3.model.S3ObjectSummary
  type Metadata = com.amazonaws.services.s3.model.ObjectMetadata

  def upload(file: java.io.File, name: String, contentType: String) = {
    val fileMetadata = new Metadata()
    fileMetadata.setContentType(contentType)
    s3.putObject(bucketName, rootFolder + name, new FileInputStream(file), fileMetadata)

    // List remote files
    //    val archivos = s3.listObjects(bucketName).getObjectSummaries().asScala.reverse
    //    archivos.foreach(x => showSummaryName(x))
  }

  private def showSummaryName(s: Summary) = {
    println(s.getKey())
  }

  def query(name: String) = {
    s3.getObject(bucketName, rootFolder + name)
  }

}