package adapter.output.presenter.user

import adapter.output.json.model.user.UserResponseConverter

import scala.concurrent.{ ExecutionContext, Future }

import play.api.mvc.{ Result, Results }

import domain.model.user.User
import domainInterface.adapter.output.CreateUserResultPresenter

class CreateUserResultPresenterImpl
  extends CreateUserResultPresenter[Result]
  with UserResponseConverter with Results {

  override def response(arg: Future[User])(implicit ec: ExecutionContext): Future[Result] = {
    arg.map(user => Ok(convertToJson(user)))
  }

}
