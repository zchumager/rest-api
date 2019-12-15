Por un error desde la JDK 8 para correr el proyecto es necesario agregar
en VM Options la linea: --add-opens java.base/jdk.internal.loader=ALL-UNNAMED

1 - Open Configuration Window: Run -> Edit Configurations -> Configuration -> VM Options
2 - Add in VM Options: --add-opens java.base/jdk.internal.loader=ALL-UNNAMED