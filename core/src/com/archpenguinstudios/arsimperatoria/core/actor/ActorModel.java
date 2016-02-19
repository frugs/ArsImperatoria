package com.archpenguinstudios.arsimperatoria.core.actor;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public class ActorModel {

    private final List<Actor> actors = new ArrayList<Actor>();

    public List<Actor> getActors() {
        return ImmutableList.copyOf(actors);
    }

    public List<Actor> getGameEntitiesWithComponent(final ComponentType componentType) {
        return ImmutableList.copyOf(Iterables.filter(actors, new Predicate<Actor>() {
            @Override
            public boolean apply(Actor actor) {
                return actor.getSupportedComponents().contains(componentType);
            }
        }));
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void removeActor(Actor actor) {
        actors.remove(actor);
    }
}
