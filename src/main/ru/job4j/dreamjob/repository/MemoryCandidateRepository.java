package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@ThreadSafe
public class MemoryCandidateRepository implements CandidateRepository {

    private int nextId = 1;

    private final Map<Integer, Candidate> candidates = new HashMap<>();

    private MemoryCandidateRepository() {
        save(new Candidate(0, "Джек Ричер", "Стажер", LocalDateTime.now()));
        save(new Candidate(0, "Итан Хант", "Джуниор", LocalDateTime.now()));
        save(new Candidate(0, "Джон Маклейн", "Джуниор+", LocalDateTime.now()));
        save(new Candidate(0, "Капитан Джек Воробей", "Мидл", LocalDateTime.now()));
        save(new Candidate(0, "Кларк Кент", "Мидл+", LocalDateTime.now()));
        save(new Candidate(0, "Лекс Лютор", "СеньерПомидор", LocalDateTime.now()));
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId++);
        candidates.put(candidate.getId(), candidate);
        return candidate;
    }

    @Override
    public boolean deleteById(int id) {
        return candidates.remove(id) != null;
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidates.computeIfPresent(candidate.getId(), (id, oldCandidate)
                -> new Candidate(oldCandidate.getId(), candidate.getName(),
                candidate.getDescription(), candidate.getCreationDate())) != null;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.ofNullable(candidates.get(id));
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
