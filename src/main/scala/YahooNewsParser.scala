import java.util.Locale

import com.treasure_data.logger.TreasureDataLogger
import org.joda.time.format.DateTimeFormat
import scala.collection.JavaConverters._

import scala.xml.XML

/**
 * Created by you on 15/02/21.
 */
object YahooNewsParser extends App {

  val rssUrl = "http://rss.dailynews.yahoo.co.jp/fc/rss.xml"
  val xml = XML.load(rssUrl)
  val items = xml \\ "item"

  var props = System.getProperties()
  props.load(getClass.getResourceAsStream("treasure-data.properties"))
  val LOG = TreasureDataLogger.getLogger("test_db")

  items map {x =>
    val title = (x \ "title").text
    val pubDate = (x \ "pubDate").text
    println(title+","+pubDate)
    
    //RFC1123
    val dateTime = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss Z").withLocale(Locale.US).parseDateTime(pubDate)
    var map = Map("title" -> title, "pubDate" -> dateTime.toDate)
    LOG.log("ynt", map.asJava.asInstanceOf[java.util.Map[String, java.lang.Object]]);
  }
  ///for(i <- items) println(i)
  //System.out.println(xml)
  //System.out.println(xml \ "channel" \\ "item" \ "title" text)
  //System.out.println(xml \ "channel" \\ "item" \ "pubDate" text)
}
