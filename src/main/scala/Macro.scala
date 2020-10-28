/** Overview
 *
 * Macro is a function generated Syntax tree when compiling.
 * Syntax tree is a data structure...
 */
import language.experimental.macros
import scala.reflect.macros.blackbox
import scala.reflect.macros.blackbox.Context // Context trait can't direct specify...

object Macro {
  def accessor(obj: Any, property: String): Any = macro impl_accessor

  def impl_accessor(c: blackbox.Context)(obj: c.Expr[Any], property: c.Expr[String]): c.universe.Select = {
    import c.universe._

    val Expr(Literal(Constant(propString: String))) = property

    Select(obj.tree, TermName(propString))
//    q"${obj}.${TermName(propString)}"
  }
  /**
   * > case class User(name: String)
   * val user = User("taro")
   * Macro.accessor(user, "name")
   * class User
   *
   * > val user = User("taro")
   * val user: User = User(taro)
   *
   * > Macro.accessor(user, "name")
   * val res0: Any = taro
   */
}
