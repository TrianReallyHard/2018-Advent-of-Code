# Running the code

Since we're given test cases I used `Minitest` to test them against the code.

To ease the running and playing with the code I recommend using a docker image. [Install docker from here](https://docs.docker.com/). Then run the below code **making sure to change the number of the day accordingly** and you are inside the day's folder. It will automatically download the correct image and run the code. Information about the test cases passing will be printed on the screen. [Click here to see how to run other bit of ruby in docker](https://hub.docker.com/_/ruby/).

`docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp ruby:2.5.3-alpine ruby day-1_test.rb`

You could also create an alias in your shell (bash):

`alias ruby=docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp ruby:2.5.3-alpine ruby`

To make the alias permanent:

`{Alias you want} > .bashrc`