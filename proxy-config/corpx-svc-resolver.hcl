Kind           = "service-resolver"
Name           = "corpx"
ConnectTimeout = "10s"
Failover = {
  "*" = {
    Datacenters = ["dc-1", "dc-3"]
  }
}