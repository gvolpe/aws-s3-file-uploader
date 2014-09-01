package controllers

import play.api.mvc.{ Action, Controller }
import aws.AWSImageUtils

object ImageController extends Controller {

  // Simple file updaloader to file system
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

      AWSImageUtils.upload(picture.ref.file, filename)
      Ok("File '" + filename + "' uploaded to AWS S3 successfully.")
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file")
    }
  }

}