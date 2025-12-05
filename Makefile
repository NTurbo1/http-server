.PHONY: build run clean

build:
	mvn clean package

run: build
	java -jar target/httpserver.jar --debug

clean:
	mvn clean