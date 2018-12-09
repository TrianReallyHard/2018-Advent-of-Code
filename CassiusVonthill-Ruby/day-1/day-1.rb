class Day1

  def parse_input(input)
    return input.split(', ').map {|x| x.to_i} 
  end

  def part_1(input)
    return parse_input(input).reduce(0, :+)
  end

end