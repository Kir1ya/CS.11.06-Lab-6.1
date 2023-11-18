# CS.11.06-Lab-6.1

**Objectives**

* Create a class in an IDE (IntelliJ)

* Read from a file

* Write to a file

* Write a method that takes a parameter

* Call a method that takes one or more parameters

* Think programmatically

* Have fun


**Materials**

You will be provided with four text files and one java file.

* testInputOneTwo.txt

* inputOneTwo.txt

* testInputThreeFour.text

* inputThreeFour.txt

* AdventureTime.java

Two text files (**testInputOneTwo.txt** and **inputOneTwo.txt**) are to be used for **Challenge 1** and **Challenge 2**. The purpose of the **testInputOneTwo.txt** file is to provide you with a smaller amount of data that you can use to more easily test your methods with. When you believe that your method is correct, use the **inputOneTwo.txt** file to get an answer to **Challenge 1** and **Challenge 2**.

Two text files (**testInputThreeFour.txt** and **inputThreeFour.txt**) are to be used for **Challenge 3** and **Challenge 4**. The purpose of the **testInputThreeFour.txt** file is to provide you with a smaller amount of data that you can use to more easily test your methods with. When you believe that your method is correct, use the **inputThreeFour.txt** file to get an answer to **Challenge 3** and **Challenge 4**.

**Instructions**

Pause. Slowly take a deep breath. In through the nose, hold it for five seconds, then slowly exhale through the mouth. Repeat this three times. Close your eyes if you feel like it. When you have finished, roll your shoulders back three times. Now, slowly and carefully read the following instructions … Sometimes, the most difficult aspect in a problem in computer science is not writing the solution, but understanding what the problem is and how to solve it. 

* This lab has **FOUR** challenges. 

* There is a single correct answer to each challenge. 

* You must write a different method to solve each challenge. 

* Your methods will be called **challengeOne**, **challengeTwo**, **challengeThree**, and **challengeFour**. 

* You must call the method **readFile** inside each of the methods that you write. **NOTE** that in one or two of the four challenges you may need to create a slightly different readFile method. If you need to do so, do not delete the original readFile method. Call the new method **readFileTwo**. So, in each of the four methods you need to call either **readFile** or **readFileTwo**.

* Each method that you write must return a value (the answer to the specific challenge).

* Test your methods inside the main method.

* When testing your methods, store the returned value from the method call into a variable. Name your variable **challengeOneAnswer**, **challengeTwoAnswer**, …

* Use these variables in a call to **writeFileAllAnswers** (pass them as arguments) to write all of your solutions to a file called **AdventureTime.txt**. This call to **writeFileAllAnswers** must also be inside the **main** method.

* Include all four methods as well as the main method in a single class called **AdventureTime**.


**Challenge 1**

Brooke is minding her own business on her ship at sea when BOOM! Amboise fires a torpedo that hits her ship and puts a massive hole in the side of it. Water begins gushing into the hull. Brooke, never one to become frazzled by events even as strenuous as having someone sink her own ship, cooly seeks refuge in a submarine she has prepared for such emergencies under the deck. She climbs aboard her submarine and launches it into the water. 

As the submarine drops below the surface of the ocean, it automatically performs a sonar sweep of the nearby sea floor. On a small screen, the sonar sweep report (your puzzle input) appears: each line is a measurement of the sea floor depth as the sweep looks further and further away from the submarine.

For example, suppose Brooke had the following report:

199

200

208

210

200

207

240

269

260

263

This report indicates that, scanning outward from the submarine, the sonar sweep found depths of 199, 200, 208, 210, and so on.

The first order of business is to figure out how quickly the depth increases, just so Brooke knows what she’s dealing with. The lower Brooke can keep under the ocean surface, the less likely Amboise will be able to pick her up on radar.

To do this, count the number of times a depth measurement increases from the previous measurement. (There is no measurement before the first measurement.) In the example above, the changes are as follows:

199 (N/A - no previous measurement)

200 (increased)

208 (increased)

210 (increased)

200 (decreased)

207 (increased)

240 (increased)

269 (increased)

260 (decreased)

263 (increased)

In this example, there are seven measurements that are larger than the previous measurement.

Using the **inputOneTwo.txt** file, write a method called **challengeOne** that takes a parameter (the name of the input text file) and returns the answer to the following question and help Brooke avoid detection from Amboise:

How many measurements are larger than the previous measurement? 

Answer 	__________________		


**Challenge 2**

Considering every single measurement isn't as useful as Brooke expected: there's just too much noise in the data. Instead, consider sums of a three-measurement sliding window. Again, considering the above example:

199  A  

200  A B   

208  A B C  

210     B C D

200  E    C D

207  E F    D

240  E F G  

269     F G H

260        G H

263            H

Start by comparing the first and second three-measurement windows. The measurements in the first window are marked A (199, 200, 208); their sum is 199 + 200 + 208 = 607. The second window is marked B (200, 208, 210); its sum is 618. The sum of measurements in the second window is larger than the sum of the first, so this first comparison increased.

Your goal now is to count the number of times the sum of measurements in this sliding window increases from the previous sum. So, compare A with B, then compare B with C, then C with D, and so on. Stop when there aren't enough measurements left to create a new three-measurement sum.

In the above example, the sum of each three-measurement window is as follows:

A: 607 (N/A - no previous sum)

B: 618 (increased)

C: 618 (no change)

D: 617 (decreased)

E: 647 (increased)

F: 716 (increased)

G: 769 (increased)

H: 792 (increased)

In this example, there are 5 sums that are larger than the previous sum.

Using the **inputOneTwo.txt** file, write a method called **challengeTwo** that has a parameter (the name of the file) and returns the answer to the following question and continue to help Brooke avoid detection from Amboise:

Consider sums of a three-measurement sliding window. How many sums are larger than the previous sum?

Answer 	__________________		


**Challenge 3**

Now, Brooke needs to figure out how to pilot this thing.

It seems like Brooke’s submarine can take a series of commands like forward 1, down 2, or up 3:

* forward X increases the horizontal position by X units.

* down X increases the depth by X units.

* up X decreases the depth by X units.

Note that since she’s on a submarine, down and up affect her depth, and so they have the opposite result of what she might expect.

The submarine seems to already have a planned course (your puzzle input). You should probably figure out where Brooke’s going. For example:

forward 5

down 5

forward 8

up 3

down 8

forward 2

Her horizontal position and depth both start at 0. The steps above would then modify them as follows:

* forward 5 adds 5 to her horizontal position, a total of 5.

* down 5 adds 5 to her depth, resulting in a value of 5.

* forward 8 adds 8 to her horizontal position, a total of 13.

* up 3 decreases her depth by 3, resulting in a value of 2.

* down 8 adds 8 to her depth, resulting in a value of 10.

* forward 2 adds 2 to her horizontal position, a total of 15.

After following these instructions, she would have a horizontal position of 15 and a depth of 10. (Multiplying these together produces 150.)

  Using the **inputThreeFour.txt** file, write a method called **challengeThree** that calculates the horizontal position and depth Brooke would have after following the planned course, and returns the answer to the following question:

What do you get if you multiply Brooke’s final horizontal position by her final depth?

Answer 	__________________


**Challenge 4**

Based on her calculations, Brooke’s planned course doesn't seem to make any sense. She finds the submarine manual and discovers that the process is actually slightly more complicated.

In addition to horizontal position and depth, she also needs to track a third value, aim, which also starts at 0. The commands also mean something entirely different than she first thought:

* down X increases her aim by X units.

* up X decreases her aim by X units.

* forward X does two things:

* It increases her horizontal position by X units.

* It increases her depth by her aim multiplied by X.

Again note that since Brooke’s on a submarine, down and up do the opposite of what she might expect: "down" means aiming in the positive direction.

forward 5

down 5

forward 8

up 3

down 8

forward 2

Now, the above example does something different:

* forward 5 adds 5 to Brooke’s horizontal position, a total of 5. Because her aim is 0, her depth does not change.

* down 5 adds 5 to her aim, resulting in a value of 5.

* forward 8 adds 8 to her horizontal position, a total of 13. Because her aim is 5, her depth increases by 8*5=40.

* up 3 decreases her aim by 3, resulting in a value of 2.

* down 8 adds 8 to her aim, resulting in a value of 10.

* forward 2 adds 2 to her horizontal position, a total of 15. Because her aim is 10, her depth increases by 2*10=20 to a total of 60.

After following these new instructions, Brooke would have a horizontal position of 15 and a depth of 60. (Multiplying these produces 900.)

Using the **inputThreeFour.txt** file, write a method called **challengeFour** that, using this new interpretation of the commands, calculates the horizontal position and depth Brooke would have after following the planned course, and returns the answer to the following question:

What do you get if you multiply her final horizontal position by her final depth?

Answer 	__________________
