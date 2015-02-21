import java.util.Locale

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

/**
 * Sandbox Class
 * * Created by you on 15/02/21.
 */
object SimpleRun extends App {

  val pubDate = "Sat, 21 Feb 2015 22:24:29 +0900"
  val dateFormat = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.US)
  val tmp = new DateTime(new java.util.Date()).toString(dateFormat)
  println(tmp)
  val dateTime = dateFormat.parseDateTime(pubDate)
}
