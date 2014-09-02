package controllers

import play.api.mvc.{ Action, Controller }
import aws.AWSFileService
import aws.S3FileHelper
import com.amazonaws.services.s3.model.AmazonS3Exception

object ImageController extends Controller {

  // Simple file uploader to file system
  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      import java.io.File
      val filename = picture.filename
      val contentType = picture.contentType
      picture.ref.moveTo(new File("/home/developer/tmp/" + filename))
      Ok("File uploaded")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }

  // Upload file to AWS S3
  def uploadS3 = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      import java.io.File
      val filename = picture.filename
      val contentType = picture.contentType

      AWSFileService.upload(picture.ref.file, filename, contentType.get)
      Ok("File '" + filename + "' uploaded to AWS S3 successfully.")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }

  def queryS3(name: String) = Action { implicit request =>
    try {
      val s3obj = AWSFileService.query(name)
      //      val file = S3FileHelper.convert(s3obj.getObjectContent())
      //      val source = scala.io.Source.fromFile(file)(scala.io.Codec.ISO8859)
      val source = scala.io.Source.fromInputStream(s3obj.getObjectContent())(scala.io.Codec.ISO8859)
      val byteArray = source.map(_.toByte).toArray
      source.close()
      Ok(byteArray).as(s3obj.getObjectMetadata().getContentType())
    } catch {
      case e: AmazonS3Exception =>
        Ok("Error: " + e.getMessage())
    }
  }

}