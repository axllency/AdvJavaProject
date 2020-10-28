package music.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MusicControllerTest {

	@Autowired
	private MockMvc mvc;
	private MvcResult result;
	private String topArtistsInput = 
			"{\r\n" + 
			"    \"items\": [\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/5XE0fiZWGbq9TcSuWwJ1fA\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 211657\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"japanese chillhop\",\r\n" + 
			"                \"lo-fi beats\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/5XE0fiZWGbq9TcSuWwJ1fA\",\r\n" + 
			"            \"id\": \"5XE0fiZWGbq9TcSuWwJ1fA\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/a6c208754efc097a35e035ba80a349566097eb38\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/1e0e8973f703cadf541c4acdc367e3a4b8bf5d1f\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/861e3feef47125917cab78cd19e843eb1f3a8276\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"potsu\",\r\n" + 
			"            \"popularity\": 70,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:5XE0fiZWGbq9TcSuWwJ1fA\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/3crR6NgDpmG78d9kDJUYAk\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 400\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/3crR6NgDpmG78d9kDJUYAk\",\r\n" + 
			"            \"id\": \"3crR6NgDpmG78d9kDJUYAk\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/c316612ce052747f2e45b5244cb573b63d109988\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/54cc2e2bfb03dc128601aa4cf9f8b141a772e2bf\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/cd791a7b62c9e5b7363d25c26e58fb0124f226dc\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Gnaw, The Rapper\",\r\n" + 
			"            \"popularity\": 27,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:3crR6NgDpmG78d9kDJUYAk\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/3pc0bOVB5whxmD50W79wwO\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 519039\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"pop\",\r\n" + 
			"                \"sad rap\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/3pc0bOVB5whxmD50W79wwO\",\r\n" + 
			"            \"id\": \"3pc0bOVB5whxmD50W79wwO\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/23aecd77f417fe941eda1442df19ad22368e874a\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/0ecd031890da185be3202bfa8d44c05fb121d137\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/4fc89b8c079a7af6d2aeb07663375349f64d7ea2\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"keshi\",\r\n" + 
			"            \"popularity\": 75,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:3pc0bOVB5whxmD50W79wwO\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/6I3MElirhT5t6Kf7p0hGk9\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 207022\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"alternative r&b\",\r\n" + 
			"                \"escape room\",\r\n" + 
			"                \"indie r&b\",\r\n" + 
			"                \"underground hip hop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/6I3MElirhT5t6Kf7p0hGk9\",\r\n" + 
			"            \"id\": \"6I3MElirhT5t6Kf7p0hGk9\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/97bce5b546795fa68c2028d1ffb643464a33e84d\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/b14e7057ad13da160e56656451c8ff9b49c5f52b\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/8a09f4bd72cb021c81e78723b0cb920d6c736b56\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Duckwrth\",\r\n" + 
			"            \"popularity\": 70,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:6I3MElirhT5t6Kf7p0hGk9\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/1bqxdqvUtPWZri43cKHac8\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 540588\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"dance pop\",\r\n" + 
			"                \"pop\",\r\n" + 
			"                \"pop rap\",\r\n" + 
			"                \"post-teen pop\",\r\n" + 
			"                \"viral pop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/1bqxdqvUtPWZri43cKHac8\",\r\n" + 
			"            \"id\": \"1bqxdqvUtPWZri43cKHac8\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/516dd84ec16920f6cf44c82738dd71240caa0a80\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/0e6697320f37f62352ccce8f44931deaef11ce5d\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/2e81e3e4f9e18c0c5239ceb6d1c72b2693b4eccf\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"MAX\",\r\n" + 
			"            \"popularity\": 80,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:1bqxdqvUtPWZri43cKHac8\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/5FxD8fkQZ6KcsSYupDVoSO\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 318219\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"alternative r&b\",\r\n" + 
			"                \"bedroom pop\",\r\n" + 
			"                \"bedroom soul\",\r\n" + 
			"                \"indie r&b\",\r\n" + 
			"                \"pop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/5FxD8fkQZ6KcsSYupDVoSO\",\r\n" + 
			"            \"id\": \"5FxD8fkQZ6KcsSYupDVoSO\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/527b5c0ee425b7bef83e7567a316e6b8a7bd5453\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/bd1b3ca7ed14f53b8cc57647efe83a0fc8e44a24\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/95086d6b062460dee76daf7655d83d023247d42f\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Omar Apollo\",\r\n" + 
			"            \"popularity\": 72,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:5FxD8fkQZ6KcsSYupDVoSO\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/53fzjsJnjEKkA6TdncuIM4\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 33163\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"deep underground hip hop\",\r\n" + 
			"                \"emo rap\",\r\n" + 
			"                \"sad rap\",\r\n" + 
			"                \"trap soul\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/53fzjsJnjEKkA6TdncuIM4\",\r\n" + 
			"            \"id\": \"53fzjsJnjEKkA6TdncuIM4\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/47e010e13db3522420d267815fd24b14125db9ee\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/c32fb958ef18b0869d5d16a4101a6458b26ac217\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/3744f0724339653f8ed2bf29e5f0d50983d6554a\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Jutes\",\r\n" + 
			"            \"popularity\": 55,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:53fzjsJnjEKkA6TdncuIM4\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/0IB0VjX9NSrGX6PjCXGVcq\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 188683\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"uk contemporary r&b\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/0IB0VjX9NSrGX6PjCXGVcq\",\r\n" + 
			"            \"id\": \"0IB0VjX9NSrGX6PjCXGVcq\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 1000,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/a5998df6dfd4c3976aee56d7de23bf0a186890a2\",\r\n" + 
			"                    \"width\": 1000\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/4f79f25ebb8f9d283fe3d85967859e72375ea983\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 200,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/05bfb19c46bf053d766775bcd734692682872d6d\",\r\n" + 
			"                    \"width\": 200\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 64,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/547de28f7a2a26c02d4391dd7ed348c80aab564f\",\r\n" + 
			"                    \"width\": 64\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Raleigh Ritchie\",\r\n" + 
			"            \"popularity\": 56,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:0IB0VjX9NSrGX6PjCXGVcq\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/2AfU5LYBVCiCtuCCfM7uVX\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 324104\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"hip hop\",\r\n" + 
			"                \"pop rap\",\r\n" + 
			"                \"rap\",\r\n" + 
			"                \"underground hip hop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/2AfU5LYBVCiCtuCCfM7uVX\",\r\n" + 
			"            \"id\": \"2AfU5LYBVCiCtuCCfM7uVX\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/983762a16a4f3b5843bd124342f7ac52c06ae0fc\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/0aeaddd2fefedc63302ed1c236e583abe993c975\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/04d73ae4ec07dd5daeeb370cc54c10f1b7086f01\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Kota the Friend\",\r\n" + 
			"            \"popularity\": 70,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:2AfU5LYBVCiCtuCCfM7uVX\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/1aSwrSGBNGMLn9ymttfRkk\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 94034\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"future bass\",\r\n" + 
			"                \"norwegian pop\",\r\n" + 
			"                \"vapor twitch\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/1aSwrSGBNGMLn9ymttfRkk\",\r\n" + 
			"            \"id\": \"1aSwrSGBNGMLn9ymttfRkk\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/b25e7b9c8a1f0cefd99853aafa4f6405a0a5974a\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/3841f2edb894594a3d4f025f52365d5282568e08\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/2cbad45b0835879c423a98c5183883f533086642\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Lido\",\r\n" + 
			"            \"popularity\": 59,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:1aSwrSGBNGMLn9ymttfRkk\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/5sKvgmG84C0bIMWeS2SRPr\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 74182\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"alternative r&b\",\r\n" + 
			"                \"indie soul\",\r\n" + 
			"                \"neo r&b\",\r\n" + 
			"                \"nyc pop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/5sKvgmG84C0bIMWeS2SRPr\",\r\n" + 
			"            \"id\": \"5sKvgmG84C0bIMWeS2SRPr\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/dc4b5cdc59bf04d3bfb9fff1be5549419a8607ed\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/7a0a9706c37bded1c9d8b51d50a3528cb37f2702\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/4c4c117db5ae5c9018e974718669dfe6d22cbd8f\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Brasstracks\",\r\n" + 
			"            \"popularity\": 59,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:5sKvgmG84C0bIMWeS2SRPr\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/6USv9qhCn6zfxlBQIYJ9qs\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 412057\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"alternative pop rock\",\r\n" + 
			"                \"pop\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/6USv9qhCn6zfxlBQIYJ9qs\",\r\n" + 
			"            \"id\": \"6USv9qhCn6zfxlBQIYJ9qs\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/152c7aa25115e6ea1d3a65e90c35222ea80f73f8\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/3adb1da948372039681a2f6e38c3fbac0c364d38\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/46dba9a0ac6ac01083de836a5906c0395feea37b\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Dominic Fike\",\r\n" + 
			"            \"popularity\": 77,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:6USv9qhCn6zfxlBQIYJ9qs\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/3HLk3BmmhoWCbL1mVP70vx\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 10660\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"dark trap\",\r\n" + 
			"                \"meme rap\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/3HLk3BmmhoWCbL1mVP70vx\",\r\n" + 
			"            \"id\": \"3HLk3BmmhoWCbL1mVP70vx\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/f1533107ae0ec336c6a8edfcbb231aec7ef776dd\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/7fc91ad1611f62b598cda836884c870dbcb9c79a\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/9d3fa9d83b4f0fb9bf8a4bebe04ac1c0be86f6eb\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Cemetery Drive\",\r\n" + 
			"            \"popularity\": 48,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:3HLk3BmmhoWCbL1mVP70vx\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/1dWEYMPtNmvSVaDNLgB6NV\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 433256\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"indie pop\",\r\n" + 
			"                \"indie poptimism\",\r\n" + 
			"                \"indie rock\",\r\n" + 
			"                \"la indie\",\r\n" + 
			"                \"modern alternative rock\",\r\n" + 
			"                \"modern rock\",\r\n" + 
			"                \"pop rock\",\r\n" + 
			"                \"rock\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/1dWEYMPtNmvSVaDNLgB6NV\",\r\n" + 
			"            \"id\": \"1dWEYMPtNmvSVaDNLgB6NV\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/342f9161a526f6ea2bf428421e0b8bd469d11eab\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/fdc7f907850dc7b0947f388ad5aed3d66d6a24cd\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/5d81d300ed2c2327deac36099db362f2565b26a4\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Saint Motel\",\r\n" + 
			"            \"popularity\": 69,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:1dWEYMPtNmvSVaDNLgB6NV\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/3Gm5F95VdRxW3mqCn8RPBJ\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 1428420\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"hip hop\",\r\n" + 
			"                \"pop rap\",\r\n" + 
			"                \"portland hip hop\",\r\n" + 
			"                \"rap\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/3Gm5F95VdRxW3mqCn8RPBJ\",\r\n" + 
			"            \"id\": \"3Gm5F95VdRxW3mqCn8RPBJ\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/474d98b081007f98edd402e5889304eade75fe57\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/b2eb77cb075bef43f55462156bbb5d2a95cca9e8\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/ea6ae0d29cf569a6828e5153e6e0ada26c6d1bba\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Aminé\",\r\n" + 
			"            \"popularity\": 79,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:3Gm5F95VdRxW3mqCn8RPBJ\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/6frffJSfCnyExIFDQEHnyf\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 4143\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/6frffJSfCnyExIFDQEHnyf\",\r\n" + 
			"            \"id\": \"6frffJSfCnyExIFDQEHnyf\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/4fd08fe0397919d8964bf0d2d96a008bec5f4f93\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/ba4a813f5db112d11d6af7584ec7a2d23e1d62aa\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/885866d1f5e9b6d17f4fd09be2f3bdb1b231e204\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Feyesal\",\r\n" + 
			"            \"popularity\": 39,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:6frffJSfCnyExIFDQEHnyf\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/62vbsDRAq0qHdezaCOzB0T\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 85000\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"edm\",\r\n" + 
			"                \"electronic trap\",\r\n" + 
			"                \"future bass\",\r\n" + 
			"                \"vapor soul\",\r\n" + 
			"                \"vapor twitch\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/62vbsDRAq0qHdezaCOzB0T\",\r\n" + 
			"            \"id\": \"62vbsDRAq0qHdezaCOzB0T\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/abe0ec511038521cb762dd2f79c1d1b2bb86812a\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/20cea2c0511d7cfe10b07628dcf43bcae97ced89\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/f8d6f4e9ed2bef0a209940874dc5cc209b4875fe\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Medasin\",\r\n" + 
			"            \"popularity\": 66,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:62vbsDRAq0qHdezaCOzB0T\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/4zjO8Jhi2pciJJzd8Q6rga\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 207669\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"bass trap\",\r\n" + 
			"                \"modern alternative rock\",\r\n" + 
			"                \"modern rock\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/4zjO8Jhi2pciJJzd8Q6rga\",\r\n" + 
			"            \"id\": \"4zjO8Jhi2pciJJzd8Q6rga\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/6c6645f81dbf86141562d43e751725f434687451\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/9a21e28438b6ba9aeae088e421197c351b787b22\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/36681b2691479ebfdf1b4bb1714714a48098665e\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Unlike Pluto\",\r\n" + 
			"            \"popularity\": 71,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:4zjO8Jhi2pciJJzd8Q6rga\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/7e3FtKBIPLrIVm8g1FJMVg\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 150699\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"abstract beats\",\r\n" + 
			"                \"alternative r&b\",\r\n" + 
			"                \"indie r&b\",\r\n" + 
			"                \"indie soul\",\r\n" + 
			"                \"vapor twitch\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/7e3FtKBIPLrIVm8g1FJMVg\",\r\n" + 
			"            \"id\": \"7e3FtKBIPLrIVm8g1FJMVg\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/b5163c2d5526534d149c9da869749d5522fa59ce\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/46a641863097054ae3c8c2cfd152c7e7e056c77d\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/da598149f0c60e94d4ac11ceb2381d851b05d15f\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Sango\",\r\n" + 
			"            \"popularity\": 59,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:7e3FtKBIPLrIVm8g1FJMVg\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"external_urls\": {\r\n" + 
			"                \"spotify\": \"https://open.spotify.com/artist/1dtZllLT0EINXgSftEnOjv\"\r\n" + 
			"            },\r\n" + 
			"            \"followers\": {\r\n" + 
			"                \"href\": null,\r\n" + 
			"                \"total\": 18373\r\n" + 
			"            },\r\n" + 
			"            \"genres\": [\r\n" + 
			"                \"meme rap\"\r\n" + 
			"            ],\r\n" + 
			"            \"href\": \"https://api.spotify.com/v1/artists/1dtZllLT0EINXgSftEnOjv\",\r\n" + 
			"            \"id\": \"1dtZllLT0EINXgSftEnOjv\",\r\n" + 
			"            \"images\": [\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 640,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/2e14c9a7c13ab96e34302aa3c5aeaab3538578a8\",\r\n" + 
			"                    \"width\": 640\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 320,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/fe52bd62a233b0e3bd588617701af8b00070b176\",\r\n" + 
			"                    \"width\": 320\r\n" + 
			"                },\r\n" + 
			"                {\r\n" + 
			"                    \"height\": 160,\r\n" + 
			"                    \"url\": \"https://i.scdn.co/image/15043fe53219ed5a8f5bd219c9f2f07b5b1c1e16\",\r\n" + 
			"                    \"width\": 160\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"name\": \"Atwood\",\r\n" + 
			"            \"popularity\": 58,\r\n" + 
			"            \"type\": \"artist\",\r\n" + 
			"            \"uri\": \"spotify:artist:1dtZllLT0EINXgSftEnOjv\"\r\n" + 
			"        }\r\n" + 
			"    ],\r\n" + 
			"    \"total\": 50,\r\n" + 
			"    \"limit\": 20,\r\n" + 
			"    \"offset\": 0,\r\n" + 
			"    \"previous\": null,\r\n" + 
			"    \"href\": \"https://api.spotify.com/v1/me/top/artists\",\r\n" + 
			"    \"next\": \"https://api.spotify.com/v1/me/top/artists?limit=20&offset=20\"\r\n" + 
			"}";
	
	@Test
	public void setFavArtists() throws Exception {
		
		//build request
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/music/favorites/artists")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(topArtistsInput);
		
		
//		//perform request
//		mvc.perform(builder)
//			//check http response code (isOk, isBadRequest, isNotFound, etc)
//			.andExpect(status().isOk())
//			//get values from field
//			.andExpect(jsonPath("######").value("###########"))
//			//get values from fields of objects within an array
//			.andExpect(jsonPath("$[0].id").value("2"))
//			//check if something is an array
//			.andExpect(jsonPath("$").isArray());
	
		//if you wanted to save the results of a request:
//		result = mvc.perform(builder)
//			.andExpect(status().isOk())
//			//return response 
//			.andReturn();
		
		//since there's no actual test right now
		assert(true);
	}
}
