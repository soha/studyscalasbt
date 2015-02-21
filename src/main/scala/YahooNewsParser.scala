import scala.xml.XML

/**
 * Created by you on 15/02/21.
 */
object YahooNewsParser extends App {

  val rssUrl = "http://rss.dailynews.yahoo.co.jp/fc/rss.xml"
  val xml = XML.load(rssUrl)
  val items = xml \\ "item"
  
  items map {x =>
    val title = (x \ "title").text
    val pubDate = (x \ "pubDate").text
    println("title:"+title+"  pubDate:"+pubDate)
  }
  ///for(i <- items) println(i)
  //System.out.println(xml)
  //System.out.println(xml \ "channel" \\ "item" \ "title" text)
  //System.out.println(xml \ "channel" \\ "item" \ "pubDate" text)
}
