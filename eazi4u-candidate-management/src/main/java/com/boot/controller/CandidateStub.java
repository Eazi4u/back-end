package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.model.Candidate;

public class CandidateStub {
	private static Map<Long, Candidate> wrecks = new HashMap<Long, Candidate>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Candidate a = new Candidate(1L, "Anele", "Chila", "Co-founder");
		wrecks.put(1L, a);
		Candidate b = new Candidate(2L, "Phelo", "Macanda", "Co-founder");
		wrecks.put(2L, b);
		Candidate c = new Candidate(3L, "Eazi", "4u", "Company");
		wrecks.put(3L, c);
	}

	public static List<Candidate> list() {
		return new ArrayList<Candidate>(wrecks.values());
	}

	public static Candidate create(Candidate wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Candidate get(Long id) {
		return wrecks.get(id);
	}

	public static Candidate update(Long id, Candidate wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Candidate delete(Long id) {
		return wrecks.remove(id);
	}
}
