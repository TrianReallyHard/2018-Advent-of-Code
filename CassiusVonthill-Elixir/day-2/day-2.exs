defmodule Day2 do

  @spec part1([]) :: integer
  def part1(input) do
    twos = Enum.count(input, fn x -> double_event?(x) end)
    threes = Enum.count(input, fn x -> triple_event?(x) end)
    twos * threes
  end

  def load_inputs(file_name) do
    File.read!(file_name) |> String.split("\n", trim: true)
  end

  @spec count_letters(String.t()) :: %{}
  defp count_letters(string_input) do
    string_input
    |> String.split("", trim: true)
    |> Enum.reduce(%{}, fn x, acc ->
      Map.update(acc, String.to_atom(x), 1, &(&1 + 1))
    end)
  end

  @spec n_event?(String.t(), integer) :: boolean
  def n_event?(string_input, n_times) do
    string_input
    |> count_letters()
    |> Map.values()
    |> Enum.any?(&(&1 == n_times))
  end

  @spec double_event?(String.t()) :: boolean
  def double_event?(string_input) do
    string_input |> n_event?(2)
  end

  @spec triple_event?(String.t()) :: boolean
  def triple_event?(string_input) do
    string_input |> n_event?(3)
  end

  # @spec part2([]) :: {String.t(), String.t()}
  # def part2(input) do

  # end

  def one_mismatch?(base_list, test_list) do
    Enum.zip(base_list, test_list)
    |> Enum.count(fn {x, y} -> x != y end)
    |> (fn x -> x == 1 end).()
  end

  def find_match_recur([], _input), do: {:missing, {}}

  def find_match_recur([head | tail], input) do
    case one_mismatch?(head, input) do
      true -> {:found, {head, input}}
      false ->  find_match_recur(tail, input)
    end
  end

  def find_match(inputs, input) do
    case find_match_recur(inputs, input) do
      {:missing, _} -> 
        
    end
  end

end