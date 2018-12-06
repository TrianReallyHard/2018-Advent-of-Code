import checksummer from "./WarehouseBoxRudimentaryChecksummer";

const boxes = [
  "abcdef",
  "bababc",
  "abbcde",
  "abcccd",
  "aabcdd",
  "abcdee",
  "ababab"
];

test("Day 2, Part 1", () => {
  expect(checksummer(boxes)).toBe(12);
});
