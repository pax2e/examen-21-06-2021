package Bestandsysteem;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class KnoopUtils {
	public Stream<Knoop> verzamelingAfstammelingen(Knoop knoop) {
		if (knoop instanceof Directory)
			return ((Directory)knoop).getIngangen().values().stream().flatMap(k -> Stream.concat(Stream.of(k), verzamelingAfstammelingen(k)));
		else
			return Stream.of(); //lege stream
	}
	
	
	public Iterator<Byte> byteIterator(Bestand bestand) {
		return new Iterator<Byte>() {
			int counter = 0;
			
			@Override
			public boolean hasNext() {
				return counter < bestand.getInhoud().length;
			}
			
			@Override
			public Byte next() {
				return bestand.getInhoud()[counter++];
			}
			
			
		};
	}
	
	public void forEachKind(Consumer<? super Knoop> consumer, Directory directory) {
		for (Knoop knoop : directory.getIngangen().values()){
			consumer.accept(knoop);
		}
	}
}
