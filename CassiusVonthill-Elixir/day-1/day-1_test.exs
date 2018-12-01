Code.load_file("day-1.exs", __DIR__)

  ExUnit.start()
  ExUnit.configure(exclude: :pending, trace: true)

defmodule Day1Test do
  use ExUnit.Case

  test "+1, +1, +1" do
    assert Day1.main("+1, +1, +1") == 3
  end

  test "+1, +1, -2" do
    assert Day1.main("+1, +1, -2") == 0
  end

  test "-1, -2, -3" do
    assert Day1.main("-1, -2, -3") == -6
  end

end