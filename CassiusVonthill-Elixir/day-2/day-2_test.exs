Code.load_file("day-2.exs", __DIR__)

ExUnit.start()
ExUnit.configure(exclude: :pending, trace: true)

defmodule Day1Test do
  use ExUnit.Case

  def event_tuple(tuple_input, index) do
    string_input = tuple_input |> elem(index)
    {Day2.double_event?(string_input), Day2.triple_event?(string_input)}
  end

  test "Part 1 examples" do
    test_inputs = Day2.load_inputs("test-input-1.txt") |> List.to_tuple()

    assert event_tuple(test_inputs, 0) == {false, false}
    assert event_tuple(test_inputs, 1) == {true, true}
    assert event_tuple(test_inputs, 2) == {true, false}
    assert event_tuple(test_inputs, 3) == {false, true}
    assert event_tuple(test_inputs, 4) == {true, false}
    assert event_tuple(test_inputs, 5) == {true, false}
    assert event_tuple(test_inputs, 6) == {false, true}

  end

  test "Part 1 challenge" do
    answer =
      Day2.load_inputs("main-input.txt")
      |> Day2.part1()

    assert answer == 8715
  end

  test "one_mismatch?([1, 2, 3], [1, 4, 3])" do
    assert Day2.one_mismatch?([1, 2, 3], [1, 4, 3])
  end

  test "matching inputs to input" do
    inputs = ["aaa", "bbb", "ccc"] |> Enum.map(&String.split(&1, "", trim: true))
    input = ["a", "b", "a"]

    output = Enum.find(inputs, false, &Day2.one_mismatch?(&1, input))
    assert output == ["a", "a", "a"]

    output = Enum.find([["z", "z", "z"]], false, &Day2.one_mismatch?(&1, input))
    assert output == false

  end

  test "Recursing through list and finding matches" do
    output = 
      ["bbb", "ccc", "aaa", "aba"]
      |> Enum.map(&String.split(&1, "", trim: true))
      |> Day2.recur()

    assert output == {["a", "a", "a"], ["a", "b", "a"]}
  end

  test "Part 2 examples" do
    answer =
      Day2.load_inputs("test-input-2.txt")
      |> Day2.part2()

    assert answer == "fgij"
  end

  test "Part 2 challenge" do
    answer =
      Day2.load_inputs("main-input.txt")
      |> Day2.part2()

    assert answer == "fvstwblgqkhpuixdrnevmaycd"
  end

end