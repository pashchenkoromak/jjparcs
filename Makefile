all: run

clean:
	rm -f out/Bluck.jar out/Requester.jar

out/Bluck.jar: out/parcs.jar src/Bluck.java src/Segment_tree.java
	@javac -cp out/parcs.jar src/Bluck.java src/Segment_tree.java
	@jar cf out/Bluck.jar -C src Bluck.class -C src Segment_tree.class
	@rm -f src/Bluck.class src/Segment_tree.class

out/Requester.jar: out/parcs.jar src/Requester.java src/Segment_tree.java
	@javac -cp out/parcs.jar src/Requester.java src/Segment_tree.java
	@jar cf out/Requester.jar -C src Requester.class -C src Segment_tree.class
	@rm -f src/Requester.class src/Segment_tree.class

build: out/Bluck.jar out/Requester.jar

run: out/Bluck.jar out/Requester.jar
	@cd out && java -cp 'parcs.jar:Bluck.jar' Bluck
