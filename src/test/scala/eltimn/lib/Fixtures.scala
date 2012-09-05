package eltimn
package lib

import net.liftweb.mapper._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._

class Foo extends LongKeyedMapper[Foo] {
  def getSingleton = Foo
  def primaryKeyField = id

  object id extends MappedLongIndex(this)
  object barId extends MappedMongoField(this, Bar)
}

object Foo extends Foo with LongKeyedMetaMapper[Foo]

class Bar private () extends MongoRecord[Bar] with ObjectIdPk[Bar] {
  def meta = Bar

  object greeting extends StringField(this, 256)
}

object Bar extends Bar with MongoMetaRecord[Bar]
