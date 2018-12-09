def parse_input_string(input_string):
  return [int(x) for x in input_string.split(", ")]


def part_1(input_string):
  return sum(parse_input_string(input_string))