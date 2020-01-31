Due to an error present on JDK 8 the line below should be added into VM Options
--add-opens java.base/jdk.internal.loader=ALL-UNNAMED

1 - Open Configuration Window: Run -> Edit Configurations -> Configuration -> VM Options
2 - Add in VM Options: --add-opens java.base/jdk.internal.loader=ALL-UNNAMED