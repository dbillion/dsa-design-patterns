#!/usr/bin/env bash
# Generates mermaid .mmd sources + renders PNGs for the dsa-design-patterns mini-projects.
set -euo pipefail
BASE=/home/deeone/Desktop/jobhunting/dsa/dsa-design-patterns
DOCS="$BASE/docs/diagrams"
mkdir -p "$DOCS"

# ---- Overview map of all 23 patterns ----
cat > "$DOCS/overview.mmd" <<'EOF'
graph TD
    subgraph Creational["Creational (5)"]
        C1[Singleton]
        C2[Factory Method]
        C3[Abstract Factory]
        C4[Builder]
        C5[Prototype]
    end
    subgraph Structural["Structural (7)"]
        S1[Adapter]
        S2[Bridge]
        S3[Composite]
        S4[Decorator]
        S5[Facade]
        S6[Flyweight]
        S7[Proxy]
    end
    subgraph Behavioral["Behavioral (11)"]
        B1[Chain of Responsibility]
        B2[Command]
        B3[Interpreter]
        B4[Iterator]
        B5[Mediator]
        B6[Memento]
        B7[Observer]
        B8[State]
        B9[Strategy]
        B10[Template Method]
        B11[Visitor]
    end
    Client[Developer / Tests] --> Creational
    Client --> Structural
    Client --> Behavioral
EOF

# ---- Per-pattern diagrams ----
cat > "$DOCS/singleton.mmd" <<'EOF'
classDiagram
    class SingletonDemo {
        +enum Singleton
        +INSTANCE Singleton
    }
    note for SingletonDemo "Enum-based singleton: serialization & reflection safe, single JVM instance"
EOF

cat > "$DOCS/factory_method.mmd" <<'EOF'
classDiagram
    Shape <|-- Circle
    Shape <|-- Square
    class Shape {
        <<sealed interface>>
    }
    class Circle {
        +double r
    }
    class Square {
        +double s
    }
    class FactoryMethodDemo {
        +create(kind, v) Shape
    }
    FactoryMethodDemo ..> Shape : produces
EOF

cat > "$DOCS/abstract_factory.mmd" <<'EOF'
classDiagram
    GUIFactory <|-- WinFactory
    GUIFactory <|-- MacFactory
    class GUIFactory {
        <<sealed interface>>
        +createButton() Button
        +createCheckbox() Checkbox
    }
    class Button { +String label }
    class Checkbox { +String label }
    GUIFactory ..> Button
    GUIFactory ..> Checkbox
EOF

cat > "$DOCS/builder.mmd" <<'EOF'
classDiagram
    class Email {
        +String to
        +String subject
        +String body
        +List~String~ cc
    }
    class Builder {
        +to(String) Builder
        +subject(String) Builder
        +body(String) Builder
        +cc(String) Builder
        +build() Email
    }
    Builder ..> Email : constructs immutable
EOF

cat > "$DOCS/prototype.mmd" <<'EOF'
classDiagram
    class Shape {
        +Point p
        +String color
        +cloneAt(Point) Shape
    }
    class Point {
        +int x
        +int y
    }
    Shape *-- Point : owns
    note for Shape "Prototype: clone with copied state, new position"
EOF

cat > "$DOCS/adapter.mmd" <<'EOF'
classDiagram
    class CelsiusSensor {
        <<interface>>
        +readC() double
    }
    class FahrenheitSensor {
        +readF() double
    }
    class Adapter {
        -FahrenheitSensor s
        +readC() double
    }
    Adapter ..|> CelsiusSensor
    Adapter *-- FahrenheitSensor : adapts
EOF

cat > "$DOCS/bridge.mmd" <<'EOF'
classDiagram
    Renderer <|-- VectorRenderer
    Renderer <|-- RasterRenderer
    class Renderer {
        <<interface>>
        +render(shape, color) String
    }
    class Shape {
        +name
        +Renderer r
        +color
        +draw() String
    }
    Shape *-- Renderer : bridge
EOF

cat > "$DOCS/composite.mmd" <<'EOF'
classDiagram
    Node <|-- File
    Node <|-- Directory
    class Node {
        <<sealed interface>>
        +size() int
    }
    class Directory {
        +List~Node~ children
        +add(Node)
    }
    Directory o-- Node : tree
EOF

cat > "$DOCS/decorator.mmd" <<'EOF'
classDiagram
    Coffee <|-- Basic
    Coffee <|-- WithMilk
    Coffee <|-- WithSugar
    class Coffee {
        <<interface>>
        +desc() String
        +cost() int
    }
    WithMilk *-- Coffee : wraps
    WithSugar *-- Coffee : wraps
EOF

cat > "$DOCS/facade.mmd" <<'EOF'
classDiagram
    class HomeTheater {
        -Dvd dvd
        -Amp amp
        -Lights lights
        +watch() List~String~
    }
    class Dvd { +on() String }
    class Amp { +on() String }
    class Lights { +dim() String }
    HomeTheater --> Dvd
    HomeTheater --> Amp
    HomeTheater --> Lights
EOF

cat > "$DOCS/flyweight.mmd" <<'EOF'
classDiagram
    class Glyph { +char c }
    class GlyphFactory {
        -Map cache
        +get(char) Glyph
    }
    class Text {
        +List~Glyph~ glyphs
        +distinctCount() int
    }
    GlyphFactory ..> Glyph : shares
    Text o-- Glyph
EOF

cat > "$DOCS/proxy.mmd" <<'EOF'
classDiagram
    Image <|-- RealImage
    Image <|-- ProxyImage
    class Image {
        <<interface>>
        +render() String
    }
    ProxyImage *-- RealImage : lazy loads
EOF

cat > "$DOCS/chain.mmd" <<'EOF'
classDiagram
    Handler <|-- Info
    Handler <|-- Warn
    Handler <|-- Error
    class Handler {
        <<sealed interface>>
        +handle(level, msg) Optional~String~
    }
    note for Handler "Chain: try each in order, first match wins"
EOF

cat > "$DOCS/command.mmd" <<'EOF'
classDiagram
    class Editor {
        -StringBuilder sb
        -Deque~Runnable~ undoStack
        +execute(String)
        +undo()
    }
    class CommandDemo
    note for Editor "Command + undo via stored Runnables"
EOF

cat > "$DOCS/interpreter.mmd" <<'EOF'
classDiagram
    Expr <|-- Var
    Expr <|-- And
    class Expr {
        <<sealed interface>>
        +eval(ctx) boolean
    }
    And *-- Expr : left/right
EOF

cat > "$DOCS/iterator.mmd" <<'EOF'
classDiagram
    class Range {
        -int lo
        -int hi
        +iterator() Iterator~Integer~
    }
    note for Range "Custom Iterable: yields lo..hi inclusive"
EOF

cat > "$DOCS/mediator.mmd" <<'EOF'
classDiagram
    class ChatRoom {
        -List~String~ log
        +send(from, msg)
    }
    note for ChatRoom "Mediator: central hub broadcasts to all"
EOF

cat > "$DOCS/memento.mmd" <<'EOF'
classDiagram
    class State { +String text }
    class Editor {
        -String text
        +save() State
        +restore(State)
    }
    Editor ..> State : snapshot
EOF

cat > "$DOCS/observer.mmd" <<'EOF'
classDiagram
    class Subject {
        -List~Consumer~String~~ subs
        +subscribe(Consumer)
        +publish(String)
    }
    note for Subject "Observer: subscribers notified on publish"
EOF

cat > "$DOCS/state.mmd" <<'EOF'
classDiagram
    State <|-- Idle
    State <|-- HasCoin
    class State {
        <<sealed interface>>
        +insert() State
        +label() String
    }
    note for State "State: transition returns next state"
EOF

cat > "$DOCS/strategy.mmd" <<'EOF'
classDiagram
    class StrategyDemo {
        +sort(list, Comparator) List
    }
    note for StrategyDemo "Strategy: pass comparator as behaviour"
EOF

cat > "$DOCS/template.mmd" <<'EOF'
classDiagram
    Beverage <|-- Tea
    Beverage <|-- Coffee
    class Beverage {
        <<abstract>>
        +make() String
        #brew() String
    }
    note for Beverage "Template: make() fixed, brew() abstract"
EOF

cat > "$DOCS/visitor.mmd" <<'EOF'
classDiagram
    Shape <|-- Circle
    Shape <|-- Rect
    class Shape {
        <<sealed interface>>
        +accept(Visitor) String
    }
    class Visitor {
        <<interface>>
        +visit(Circle) String
        +visit(Rect) String
    }
    Shape ..> Visitor : double dispatch
EOF

echo "Wrote $(ls "$DOCS"/*.mmd | wc -l) mermaid sources"
