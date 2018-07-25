package contracts.twitter.tweet.collector

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
Retrieves tweets for a given hashtag

given:
	you want to search tweets for a hashtag
when:
	you search tweets for a hashtag
then:
	you'll receive the tweets for this hashtag
""")
    request {
        method('GET')
        url('/tweets/search/hashtag/wm') {
            queryParameters {
                parameter('lang', equalTo("en"))
                parameter('since', equalTo("2018-01-01"))
                parameter('count', 1)
            }
        }
    }
    response {
        status(200)
        body("""
[{"createdAt":"2018-06-26T20:38:28.000+0000","text":"RT @LMatthaeus10: Ger vs Eng #WM #FIFA18 @EASPORTSFIFA https://t.co/6bp5XZ4fIc","hashTagEntities":[{"text":"WM"},{"text":"FIFA18"}]}]
""")
        headers {
            contentType(applicationJson())
        }
    }
}