require 'set'

class Day1

  def parse_input(input)
    return input.split(', ').map {|x| x.to_i} 
  end

  def part_1(input)
    return parse_input(input).reduce(0, :+)
  end

  def part_2(input)
    base = 0
    cache = Set.new [0]
    parse_input(input).cycle do |x|
      base += x
      if cache.include? base
        return base
      else
        cache.add(base)
      end
    end
  end

end