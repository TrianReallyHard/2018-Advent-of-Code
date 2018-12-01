defmodule Day1 do
  def main(string_input) do
    Regex.scan(~r/[+-]\d+?/, string_input)
    |> List.flatten()
    # |> IO.inspect(label: "Flattened data")
    |> Enum.reduce(0, fn num, acc -> elem(Integer.parse(num), 0) + acc end)
  end
end