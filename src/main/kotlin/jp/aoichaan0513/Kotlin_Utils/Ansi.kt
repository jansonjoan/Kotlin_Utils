package jp.aoichaan0513.Kotlin_Utils

class Ansi(private val input: String) {

    companion object {

        val RESET = "\u001B[0m"

        val BOLD = "\u001B[1m"
        val ITALIC = "\u001B[3m"
        val UNDERLINE = "\u001B[4m"

        val FOREGROUND_BLACK = "\u001B[30m"
        val FOREGROUND_RED = "\u001B[31m"
        val FOREGROUND_GREEN = "\u001B[32m"
        val FOREGROUND_YELLOW = "\u001B[33m"
        val FOREGROUND_BLUE = "\u001B[34m"
        val FOREGROUND_MAGENTA = "\u001B[35m"
        val FOREGROUND_CYAN = "\u001B[36m"
        val FOREGROUND_WHITE = "\u001B[37m"

        val BACKGROUND_BLACK = "\u001B[40m"
        val BACKGROUND_RED = "\u001B[41m"
        val BACKGROUND_GREEN = "\u001B[42m"
        val BACKGROUND_YELLOW = "\u001B[43m"
        val BACKGROUND_BLUE = "\u001B[44m"
        val BACKGROUND_MAGENTA = "\u001B[45m"
        val BACKGROUND_CYAN = "\u001B[46m"
        val BACKGROUND_WHITE = "\u001B[47m"
    }

    fun reset() = Ansi("$RESET$input")

    fun bold() = Ansi("$BOLD$input")
    fun italic() = Ansi("$ITALIC$input")
    fun underline() = Ansi("$UNDERLINE$input")

    fun foreground() = AnsiForeground(input)
    fun background() = AnsiBackground(input)

    fun clear() = Ansi(input.replace("\u001B\\[([0-4]|3[0-7]|4[0-7])m".toRegex(), ""))

    override fun toString() = input

    class AnsiForeground(private val input: String) {

        fun black() = Ansi("$FOREGROUND_BLACK$input")
        fun red() = Ansi("$FOREGROUND_RED$input")
        fun green() = Ansi("$FOREGROUND_GREEN$input")
        fun yellow() = Ansi("$FOREGROUND_YELLOW$input")
        fun blue() = Ansi("$FOREGROUND_BLUE$input")
        fun magenta() = Ansi("$FOREGROUND_MAGENTA$input")
        fun cyan() = Ansi("$FOREGROUND_CYAN$input")
        fun white() = Ansi("$FOREGROUND_WHITE$input")
    }

    class AnsiBackground(private val input: String) {

        fun black() = Ansi("$BACKGROUND_BLACK$input")
        fun red() = Ansi("$BACKGROUND_RED$input")
        fun green() = Ansi("$BACKGROUND_GREEN$input")
        fun yellow() = Ansi("$BACKGROUND_YELLOW$input")
        fun blue() = Ansi("$BACKGROUND_BLUE$input")
        fun magenta() = Ansi("$BACKGROUND_MAGENTA$input")
        fun cyan() = Ansi("$BACKGROUND_CYAN$input")
        fun white() = Ansi("$BACKGROUND_WHITE$input")
    }
}