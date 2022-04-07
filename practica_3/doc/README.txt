Esta practica 2 de la asignatura Procesadores de Lenguajes 21-22 fue realizada por:
Marcos Garralaga Blasco (795936[@unizar.es])
Victor Gallardo Sánchez (801159[@unizar.es])

La política de recuperación de errores que se ha utilizado es el modo pánico. En caso de encontrar un error el compilador saltará tokens 
hasta que encuentre un "end" o un ";". El modo pánico se lleva a cabo a nivel de instrucción y de bloque, por lo que si el error da en una instrucción while o if, salta tokens hasta el "end". Sin embargo si revienta en otra situación salta tokens hasta el ";".
Cabe recordar que si por ejemplo, hay un if dentro de un while y el error se comete en el while, comerá hasta el primer "end" que se encuentre, es decir el del if. Esto es un caso de error semántico que se tratará mas adelante.
