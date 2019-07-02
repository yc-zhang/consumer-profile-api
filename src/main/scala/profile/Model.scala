package profile

case class Collection(id: String, name: String, description: String)
case class Subscription(name: String)
case class Address(postCode: String, lines: List[String])
case class Profile(id: String, name: String, age: Int,
                   address: Address,
                   subscriptions: List[Subscription],
                   collections: List[Collection])
