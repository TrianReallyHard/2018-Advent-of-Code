defmodule Day2 do

  # def part1(file_name) do
  # end

  # def part2(file_name) do
  # end

  def load_inputs(file_name) do
    File.read!(file_name)
    |> String.split("\n", trim: true)
  end

  @spec count_letters(String.t()) :: %{}
  def count_letters(string_input) do
    string_input
    |> String.split("", trim: true)
    |> Enum.reduce(%{}, fn x, acc ->
      Map.update(acc, String.to_atom(x), 1, &(&1 + 1))
    end)
  end

  # Map.update(%{a: 3}, String.to_atom("a"), 1, &(&1 + 1))

end