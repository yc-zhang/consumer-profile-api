package profile

class ProfileRepo {
  def profile(id: String): Option[Profile] = Some(Sample.profile)

  def profiles: List[Profile] = List(Sample.profile)
}

object Sample {
  val collections = (1 to 20).map(index => Collection(index.toString, s"name: + $index", "")).toList
  val subscriptions = (1 to 5).map(index => Subscription(s"${index.toString} subscription")).toList
  val address = Address("712000", List("line1", "line2", "line3"))
  val profile = Profile("1", "sample profile", 28, address, subscriptions, collections)
}