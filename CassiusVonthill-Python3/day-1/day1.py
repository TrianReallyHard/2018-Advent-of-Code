import itertools

def parse_input_string(input_string):
  return [int(x) for x in input_string.split(", ")]


def part_1(input_string):
  return sum(parse_input_string(input_string))

def part_2(input_string):
  base = 0
  cache = {0}
  for x in itertools.cycle(parse_input_string(input_string)):
    base = base + x
    if base in cache:
      return base
    else:
      cache.add(base)
