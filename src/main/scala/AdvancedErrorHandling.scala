object AdvancedErrorHandling {

}

sealed trait LoginError
case object InvalidPassword extends LoginError // when password mistake
case object UserNotFound extends LoginError    // when target user can't find
case object PasswordLocked extends LoginError  // when user password is Locked

case class User(id: Long, name: String, password: String)

object LoginService {
  def login(name: String, password: String): Either[LoginError, User] = {
    (name, password) match {
      case ("taro", "Password1") => Right(User(1, name, password))
      case ("taro", _) => Left(InvalidPassword)
      case (_, _) => Left(UserNotFound)
    }
  }
}

/**
 * scala>
 * LoginService.login(name = "taro", password = "Password1") match {
 *   case Right(user) => println(s"id: ${user.id}")
 *   case Left(InvalidPassword) => println(s"Invalid Password!")
 *   case Left(UserNotFound) => println(s"User Not Found!")
 *   case Left(PasswordLocked) => println(s"Password Locked!")
 * }
 *
 * id: 1
 */

// TODO: 【実習】Either への map や flatMap の適用