package eltimn
package lib

class MappedMongoSpec extends MongoBaseSpec {
  def models = List(Foo)

  "MappedMongoField" should {
    "set and retrieve a MongoRecord" in {
      val bar = Bar.createRecord
        .greeting("Hola")
        .save

      val foo = Foo.create
        .barId(bar)
        .saveMe

      println(foo.barId.obj)
      println(bar)

      val barObj = foo.barId.obj

      barObj should be ('defined)

      barObj.foreach { b =>
        b.id.is should be (bar.id.is)
      }
    }
  }
}

