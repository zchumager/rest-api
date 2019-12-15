Property Expression
Permite construir una Custom Query utilizando solo una Convencion

Ejemplos

para buscar por un atributo
findByAttribute(T parameter)

para buscar por un atributo u otro
findByAttributeAndOtherAttribute(T parameter1, T parameter2)

para buscar por el atributo de un objeto atributo
findByObject_Attribute(T parameter)
 
Nota: El guion bajo seria la substitucion del punto ya que el atributo
original luciria asi:
    object.attribute
