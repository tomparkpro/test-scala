def hi = "hi"
hi

def hi2: String = "hi2"
hi2

def multiplier(x: Int, y: Int): Int = {x * y}
multiplier(6, 7)

def safeTrim(s: String): String = {
  if (s == null) return null
  s.trim()
}

def log(d: Double) = println(f"Got value $d%.2f")

def log2(d: Double): Unit = println(f"Got value $d%.2f")

log2(2.23535)

def log3(d: Double) { println(f"Got value $d%.2f") }

def hi3(): String = "hi3"
hi3()

hi3

def formatEuro(amt: Double) = f"€$amt%.2f"
formatEuro(3.4645)

formatEuro {
  val rate = 1.32
  0.235 + 0.7123 + rate * 5.32
}







