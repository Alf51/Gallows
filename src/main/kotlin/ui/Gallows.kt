package org.example.ui

object Gallows {
    val maxStages: Int
        get() = stages.size

    fun draw(stage: Int) {
        if (stage in stages.indices) {
            println(stages[stage])
        } else {
            println("Неверный этап: $stage")
        }
        println("=============================")
    }

    private val stages = listOf(
        """
            __________
            ||       |
            ||        
            ||
            ||
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||         
            ||      
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||        )   
            ||       
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||      ( )   
            ||       
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||      ( )   
            ||      ( 
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||      ( )   
            ||      ( )
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||     /( )   
            ||      ( )
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||     /( )\   
            ||      ( )
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||     /( )\   
            ||      (_)
            ||             
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||     /( )\   
            ||      (_)
            ||      |        
         __{||}__
        """.trimIndent(),

        """
            __________
            ||       |
            ||       0 
            ||     /( )\   
            ||      (_)
            ||      | |       
         __{||}__
        """.trimIndent()
    )
}