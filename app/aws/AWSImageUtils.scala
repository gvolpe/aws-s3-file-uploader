package aws

import awscala._, s3._
import scala.collection.JavaConverters._

object AWSImageUtils {

  // EU_Ireland = eu-west-1 >> http://docs.aws.amazon.com/general/latest/gr/rande.html#s3_region
  //implicit val s3 = S3.at(Region.EU_Ireland.toAWSRegion())
  //implicit val s3 = S3(Credentials("CONSULTAR-SYSADMIN", "CONSULTAR-SYSADMIN"))

  implicit val s3 = S3()

  private val bucketName = "etermax-profile-picture"

  type Summary = com.amazonaws.services.s3.model.S3ObjectSummary

  def upload(file: java.io.File, name: String) = {
    s3.putObject(bucketName, "playchat/" + name, file)

    // List remote files
    //    val archivos = s3.listObjects(bucketName).getObjectSummaries().asScala.reverse
    //    archivos.foreach(x => showSummaryName(x))
  }

  private def showSummaryName(s: Summary) = {
    println(s.getKey())
  }

}