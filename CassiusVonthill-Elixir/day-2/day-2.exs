defmodule Day2 do

  def part1(input) do
    input =
      input
      |> Enum.map(fn x -> {x, double_event(x), triple_event(x)} end)

    twos = input |> Enum.count(fn {_x, y, _z} -> y end)

    threes = input |> Enum.count(fn {_x, _y, z} -> z end)

    twos * threes
  end

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

  @spec n_event(String.t(), integer) :: boolean
  def n_event(string_input, n_times) do
    string_input
    |> count_letters()
    |> Map.values()
    |> Enum.find_value(false, &(&1 == n_times))
  end

  @spec double_event(String.t()) :: boolean
  def double_event(string_input) do
    string_input |> n_event(2)
  end

  @spec double_event(String.t()) :: boolean
  def triple_event(string_input) do
    string_input |> n_event(3)
  end

end