import fs from "fs";
import checksummer from "./WarehouseBoxRudimentaryChecksummer";

fs.readFile("./day-2/input.txt", "utf-8", (err, data) => {
  if (err) throw err;
  const lines = data.trim().split("\n");
  process.stdout.write(`${checksummer(lines)}\n`);
});
