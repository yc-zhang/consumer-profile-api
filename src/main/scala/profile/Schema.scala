package profile

import sangria.schema._

object ProfileSchema {
  val CollectionType = ObjectType(
    "Collection",
    "The collection type",
    fields[Unit, Collection](
      Field("id", StringType, resolve = _.value.name),
      Field("name", StringType, resolve = _.value.name),
      Field("description", StringType, resolve = _.value.description)))

  val SubscriptionType = ObjectType(
    "Subscription",
    "The subscription type",
    fields[Unit, Subscription](
      Field("name", StringType, resolve = _.value.name)
    ))

  val AddressType = ObjectType(
    "Address",
    "The address type",
    fields[Unit, Address](
      Field("postCode", StringType, resolve = _.value.postCode),
      Field("lines", ListType(StringType), resolve = _.value.lines)
    ))

  val ProfileType = ObjectType(
    "Profile",
    "the aggregate of the attributes",
    fields[Unit, Profile](
      Field("id", StringType, resolve = _.value.id),
      Field("name", StringType, resolve = _.value.name),
      Field("age", IntType, resolve = _.value.age),
      Field("address", AddressType, resolve = _.value.address),
      Field("subscriptions", ListType(SubscriptionType), resolve = _.value.subscriptions),
      Field("collections", ListType(CollectionType), resolve = _.value.collections)
    )
  )

  val Id = Argument("id", StringType)

  val QueryType = ObjectType("Query", fields[ProfileRepo, Unit](
    Field("profile", OptionType(ProfileType),
      description = Some("Returns a profile with specific `id`."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.profile(c arg Id)),

    Field("profiles", ListType(ProfileType),
      description = Some("Returns a list of all profiles."),
      resolve = _.ctx.profiles))
  )

  val schema = Schema(QueryType)
}
