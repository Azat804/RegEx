import RegEx.find
import java.io.*
import java.util.*
import java.util.regex.Pattern


object RegEx {
    fun find(
            text: String,
            regex: String?
    ): ArrayList<String> {
        val p = Pattern.compile(regex, Pattern.MULTILINE or Pattern.UNICODE_CHARACTER_CLASS or Pattern.CASE_INSENSITIVE)
        val m = p.matcher(text)
        val result = ArrayList<String>()
        while (m.find()) {
            val b = m.start()
            val e = m.end()
            result.add(text.substring(b, e))
        }
        return result
    }
}
fun main() { //var r = new RegEx();

    //var r = new RegEx();
    try {
        val fis = FileInputStream("text.txt")
        val isr = InputStreamReader(fis)
        val br = BufferedReader(isr)
        val sb = StringBuilder()
        while (br.ready()) {
            sb.append(br.readLine())
            sb.append("\n")
        }
        val s = sb.toString()
        br.close()
        val regex = "(?<=\\s)(?:[0-1]?\\d|2[0-3]):[0-5]\\d(?::[0-5]\\d)?(?=[;.,!?-]?\\s)"
        val res = find(s, regex)
        for (line in res) {
            println(line)
        }
    } catch (e: FileNotFoundException) {
        println("Не удалось найти указанный файл")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}