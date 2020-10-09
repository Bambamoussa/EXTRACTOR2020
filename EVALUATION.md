     ## test JUnit

     - PageTest : the JUnit tests of the PageTest class work at about 90%
                  the tests fail at the getTitleWithoutSpace () method
                  this function does not manage to extract the title of wikipédias links containing accents

     -SavePathTest:


     - ExtractorTest: the JUnit tests of the ExtractorTest class work at about 90%

                      the problem lies in the compareNumberOfTable method which compares the number of tables found with the number of tables in the wikipedia link


                     the problem lies with the compareNumberOfTable method which compares the number of rows found in the table with the number of rows in the csv




     -PageCheckerTest : the JUnit tests of the PageCheckerTestTest class work at about 95%

                    the TestJUnit of the existingPagesTest_WithoutHttps () method fails to Check if a page without http can be tested