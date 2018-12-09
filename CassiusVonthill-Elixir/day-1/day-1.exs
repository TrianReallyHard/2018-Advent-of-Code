defmodule Day1 do

  def part1(string_input) do
    parse_input(string_input)
    |> Enum.sum()
  end

  def part2(string_input) do
    parse_input(string_input)
    # |> IO.inspect(label: "Parsed Data")
    |> Stream.cycle()
    # |> IO.inspect(label: "Cycle data")
    |> Enum.reduce_while({0, MapSet.new([0])}, fn x, {base, ms} -> 
      base =
        base
        |> Kernel.+(x)
        # |> IO.inspect(label: "Base")

      if MapSet.member?(ms, base) do
        # IO.puts("true")
        {:halt, {base, ms}}
      else
        # IO.puts("false")
        ms = 
          MapSet.put(ms, base)
          # |> IO.inspect()
        {:cont, {base, ms}}
      end
    end)
    |> elem(0)
  end

  def parse_input(string_input) do
    string_input
    |> String.split(", ")
    |> Enum.map(&String.to_integer(&1))
    # |> IO.inspect(label: "Numerical data")
  end

end