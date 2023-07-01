package lectures.part2oop

object Enums extends App{
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocumnet(): Unit = {
      if (this == READ) println("opening document")
      else println("you don't have read permission")
    }
  }

  //constructor arguments
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }

  //companion object
  object PermissionWithBits{
    def fromBits(bits: Int) : PermissionWithBits = {
      //whatever execution you want
      PermissionWithBits.NONE
    }
  }

  val somePermission: Permissions = Permissions.READ
  println(somePermission.openDocumnet())

  //standard API
  val somePermissionOrdinal = somePermission.ordinal  //give index of the enum value associated with it
  val allPermission = PermissionWithBits.values       //array of all possible values of the enum
  val readPermission = PermissionWithBits.valueOf("READ")

}
