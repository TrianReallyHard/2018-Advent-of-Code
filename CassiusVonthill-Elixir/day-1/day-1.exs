defmodule Day1 do
  def part1(string_input) do
    Regex.scan(~r/[+-]\d+/, string_input)
    |> List.flatten()
    |> IO.inspect(label: "Flattened data")
    |> Enum.reduce(0, fn num, acc -> String.to_integer(num) + acc end)
  end
end