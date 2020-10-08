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

object MainRefactored {
  case class Address(id: Int, name: String, postalCode: Option[String])
  case class User(id: Int, name: String, addressId: Option[Int])

  val userDatabase: Map[Int, User] = Map (
    1 -> User(1, "太郎", Some(1)),
    2 -> User(2, "二郎", Some(2)),
    3 -> User(3, "プー太郎", None)
  )

  val addressDatabase: Map[Int, Address] = Map (
    1 -> Address(1, "渋谷", Some("150-0002")),
    2 -> Address(2, "国際宇宙ステーション", None)
  )

  sealed abstract class PostalCodeResult
  case class Success(postalCode: String) extends PostalCodeResult
  abstract class Failure extends PostalCodeResult
  case object UserNotFound extends Failure
  case object UserNotHasAddress extends Failure
  case object AddressNotFound extends Failure
  case object AddressNotHasPostalCode extends Failure

  // 本質的に何をしているかわかりやすくリファクタリング
  def getPostalCodeResult(userId: Int): PostalCodeResult = {
    (for {
      user <- findUser(userId).right
      address <- findAddress(user).right
      postalCode <- findPostalCode(address).right
    } yield Success(postalCode)).merge
  }

  def findUser(userId: Int): Either[Failure, User] = {
    userDatabase.get(userId).toRight(UserNotFound)
  }

  def findAddress(user: User): Either[Failure, Address] = {
    for {
      addressId <- user.addressId.toRight(UserNotHasAddress).right
      address <- addressDatabase.get(addressId).toRight(AddressNotFound).right
    } yield address
  }

  def findPostalCode(address: Address): Either[Failure, String] = {
    address.postalCode.toRight(AddressNotHasPostalCode)
  }

  def main(args: Array[String]): Unit = {
    println(getPostalCodeResult(1)) // Success(150-0002)
    println(getPostalCodeResult(2)) // AddressNotHasPostalCode
    println(getPostalCodeResult(3)) // UserNotHasAddress
    println(getPostalCodeResult(4)) // UserNotFound
  }
}

/**
 * まとめ
 * Option で渡す情報以上のエラー情報を渡すときに Either を用いる
 * Either は Left と Right より構成され、正常系には Right を利用する
 * Try は Success と Failure より構成され、処理内で例外が投げられると Failure となる
 */

//def createString(size: Int): scala.util.Try[String] = ???
