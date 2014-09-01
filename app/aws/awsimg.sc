package aws

object awsimg {
  
  val file = new java.io.File("/home/developer/sample.txt")
                                                  //> file  : java.io.File = /home/developer/sample.txt
  
  AWSImageUtils.upload(file)                      //> user_n_2.jpg
                                                  //| test.png
                                                  //| sample.txt
                                                  //| prueba/user_n_2.jpg
                                                  //| README.md
                                                  //| 9/97c4c42cc505ecf64d18c524554c7ed72128a7e5_t.jpg
                                                  //| 9/97c4c42cc505ecf64d18c524554c7ed72128a7e5_p.jpg
                                                  //| 9/97c4c42cc505ecf64d18c524554c7ed72128a7e5_l.jpg
                                                  //| 8/b604e698e196763841103ae108bb947e70d989bc_t.jpg
                                                  //| 8/b604e698e196763841103ae108bb947e70d989bc_p.jpg
                                                  //| 8/3c147972b6363e12e2632a423ad6b57d6ac4e841_t.jpg
                                                  //| 8/3c147972b6363e12e2632a423ad6b57d6ac4e841_p.jpg
                                                  //| 8/111f26eb500c450c7eb620a9e7338ddccf1701be_t.jpg
                                                  //| 8/111f26eb500c450c7eb620a9e7338ddccf1701be_p.jpg
                                                  //| 8/111f26eb500c450c7eb620a9e7338ddccf1701be_l.jpg
                                                  //| 5/c830f3fe673c95e815165dd7876d63b2c24c613c_t.jpg
                                                  //| 5/c830f3fe673c95e815165dd7876d63b2c24c613c_p.jpg
                                                  //| 5/c830f3fe673c95e815165dd7876d63b2c24c613c_l.jpg
                                                  //| 5/67ec88c26536a46b170e2bb17d64d53de9ef6a05_t.jpg
                                                  //| 5/67ec88c26536a46b170e2bb17d64d53de9ef6a05_p.jpg
                                                  //| 5/67ec88c26536a46b170e2bb17d64d53de9ef6a05_l.jpg
                                                  //| 5/08fc5369150095eca40c2f99e4273b8c3228c34f_t.jpg
                                                  //| 5/08fc536915
                                                  //| Output exceeds cutoff limit.
  
}