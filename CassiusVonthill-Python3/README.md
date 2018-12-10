# Running the code

Since we're given test cases I used `unittest` to test them against the code.

To ease the running and playing with the code I recommend using a docker image. [Install docker from here](https://docs.docker.com/). Then run the below code **making sure to change the number of the day accordingly** and you are inside the day's folder. It will automatically download the correct image and run the code. Information about the test cases passing will be printed on the screen. [Click here to see how to run other bit of elixir in docker](https://hub.docker.com/_/python/).

`docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp python:3.7.1-alpine python test_day1.py`

You could also create an alias in your shell (bash):

`alias python=docker run -it --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp python:3.7.1-alpine python test_day1.py`

To make the alias permanent:

`{Alias you want} > .bashrc`